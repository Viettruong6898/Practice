import React from "react";


class Form extends React.Component {
	render(){
		return(
			<form onSubmit={this.props.getStudents} >
			 {/* name is what we refer to placeholder is what shows */}
			<input type="text" name="Skey" placeholder="Key"/>
			<button> Get Weather </button>
			</form>
			);
	}
}
export default Form