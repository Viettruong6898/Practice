import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Titles from "./Components/Titles";
import Form from "./Components/Form";
import Students from "./Components/Students";


const APkey = "5d67df0e084c6242d5192b0a595cc57d";
class App extends Component {
  state = {
    temperature: undefined,
    city: undefined,
    country : undefined,
    humidity : undefined,
    description : undefined,
    error : undefined
  }
	getStudents = async (e) => {
    e.preventDefault();
    {/* the key constant allows for dynamic value access, if we enter a certain value, then
    paste it straight into the url using ${key} at the appro location*/}
    const key = e.target.elements.Skey.value;
    const api_call = await fetch("http://api.openweathermap.org/data/2.5/weather?q="+ key +"&mode=json&appid=" + APkey + "&units=metric");
    const data = await api_call.json();
    if( key ){
    console.log(data);
    {/* never update the state by doing dot on each part, update using setstate */}
    this.setState({ 
      temperature: data.main.temp,
      city: data.name,
      country : data.sys.country,
      humidity: data.main.humidity,
      description : data.weather[0].description,
      error: ""
    }
    )
  } else {
    this.setState({ 
      temperature: undefined,
      city: undefined,
      country : undefined,
      humidity: undefined,
      description : undefined,
      error: "Please enter a value"
  });
}}
  
  render() {
    {/* this render method is what is displayed on the screen */}
    return (
      <div>
      <Titles />
      {/*This  notation allows you to pass the method from one file to another
      so now the form file can access the get students method, other word allow acces in other files */}
      <Form getStudents={this.getStudents} />
      <Students 
      temperature={this.state.temperature}
      city={this.state.city}
      country={this.state.country}
      humidity={this.state.humidity}
      description={this.state.description}
      error={this.state.error}

       />
      </div>
    );
  }
}

export default App;

