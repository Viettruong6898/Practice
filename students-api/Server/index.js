const {GraphQLServer} = require('graphql-yoga');
const mongoose = require("mongoose");

mongoose.connect("mongodb://localhost/studentdata")

const Students = mongoose.model('Students',{
    name: String,
    address: String
});

const dancer = mongoose.model('dancer',{
  type: String,
  dancer: String
});

const typeDefs = `
  type Query {
    hello(name: String): String!
    getStudents: [Students]
  }
  type Students{
    id: ID!
    name: String!
    address: String!
  }
  type dancer{
    id: ID!
    type: String!
    dancer: String!
  }
  type Mutation {
      createStudents(name: String!): Students
      updateinfo(id: ID!, name: String!): Boolean
      deleteinfo(id: ID!):Boolean
      makedance(type: String!): dancer
  }
`;

const resolvers = {
  Query: {
    hello: (_, { name }) => `Hello ${name || 'World'}`,
    getStudents: () => Students.find()
  },
  Mutation: {
      createStudents: async (_,{name}) => {
        const student = new Students({name});
        await student.save();
        return student; 
    },
      makedance: async(_,{type}) => {
      const dance = new dancer({type});
      await dance.save();
      return dance;
    },
    updateinfo: async(_,{id,name}) => {
      await Students.findByIdAndUpdate(id,{name});
      return true;
    },
    deleteinfo:async(_,{id,name}) => {
      await Students.findByIdAndRemove(id);
      return true;

    }
  }
};

const server = new GraphQLServer({ typeDefs, resolvers });
mongoose.connection.once("open",function() {
server.start(() => console.log("Server is running on localhost:4000"));}); 