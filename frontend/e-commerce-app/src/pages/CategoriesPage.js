import React from "react";
import Table from 'react-bootstrap/Table';

class CategoriesPage extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      categories : []
    };
  }

  componentDidMount(){

    const uri = "http://localhost:8080/api/v1/categories/allCategories";

    fetch(uri) 
    .then((response) => response.json())
    .then((jsonResponse) => {
      console.log(jsonResponse);
      this.setState({categories : jsonResponse});   
    }).catch((err) => console.log(err));
  }

  render(){
    return (
        <Table striped bordered hover>
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>                       
                </tr>
            </thead>
            <tbody>
            {
                this.state.categories.map( (category) => {
                    return(
                        <tr key={category.id}>
                            <td>{category.id}</td>
                            <td>{category.name}</td>              
                        </tr>
                    )      
                })
            }
            </tbody>
        </Table>
      );
  }
}

export default CategoriesPage;