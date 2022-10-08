import React from "react";
import Table from 'react-bootstrap/Table';

class ClientsPage extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      clients : []
    };
  }

  componentDidMount(){

    const uri = "http://localhost:8080/api/v1/clients/allClients";

    fetch(uri) 
    .then((response) => response.json())
    .then((jsonResponse) => {
      console.log(jsonResponse);
      this.setState({clients : jsonResponse});   
    }).catch((err) => console.log(err));
  }

  render(){
    return (
        <Table striped bordered hover>
            <thead>
                <tr>
                    <th>user name</th>
                    <th>full name</th>
                    <th>mail</th>
                    <th>mobile number</th>                        
                </tr>
            </thead>
            <tbody>
            {
                this.state.clients.map( (client) => {
                    return(
                        <tr key={client.userName}>
                            <td>{client.userName}</td>
                            <td>{client.fullName}</td>
                            <td>{client.mail}</td>
                            <td>{client.mobileNumber}</td>                        
                        </tr>
                    )      
                })
            }
            </tbody>
        </Table>
      );
  }
}

export default ClientsPage;