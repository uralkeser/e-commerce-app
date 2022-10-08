import React from "react";
import Table from 'react-bootstrap/Table';
class ClientPage extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      clients : [{
        fullName: "asddddd",
        userName: "asdasdas",
        mail: "ssddddds",
        mobileNumber: "ddddd"
      },
      // {
      //   name: "bbbb",
      //   imageUrl: "bbb",
      //   price: 2,
      //   discount: 22,
      //   categoryId: 222,
      //   vendorUserId: 222
      // },
      // {
      //   name: "cccc",
      //   imageUrl: "ccc",
      //   price: 3,
      //   discount: 33,
      //   categoryId: 333,
      //   vendorUserId: 3333
      // }
    ]
    };
  }

  componentDidMount(){

    const uri = "http://localhost:8080/api/v1/users/allClients";

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
      <Table striped bordered hover>
          <thead>
            <tr>
              <th>#</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Username</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Mark</td>
              <td>Otto</td>
              <td>@mdo</td>
            </tr>
            <tr>
              <td>2</td>
              <td>Jacob</td>
              <td>Thornton</td>
              <td>@fat</td>
            </tr>
            <tr>
              <td>3</td>
              <td colSpan={2}>Larry the Bird</td>
              <td>@twitter</td>
            </tr>
          </tbody>
        </Table>
  }
}

export default ClientPage;