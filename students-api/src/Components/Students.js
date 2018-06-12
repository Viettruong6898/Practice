
import React from "react";

{/* using the && operators as if statements. We dont want just the location popping up*/}
class Students extends React.Component {
	render(){
		return(
			<div>  
			{this.props.city && this.props.country && <p> Location: {this.props.city},{this.props.country} </p> }
			{this.props.temperature && <p>Temperature: {this.props.temperature} </p>}
			{this.props.Humidity &&<p> Humidity: {this.props.humidity} </p> }
			{this.props.description && <p> Description: {this.props.description} </p>}
			{this.props.error && <p>{this.props.error}</p>} 
			</div>
			);
	}
}
export default Students