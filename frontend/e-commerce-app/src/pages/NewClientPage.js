import React from 'react'; 
import InformArea from '../component/InformArea/InformArea';
import Form from '../component/Form/Form';
import AppConfig from '../config/AppConfig';

class NewClientPage extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      isFormSubmit: false,
      response: 'success',
      message: '',
    }
  }  

  handleSubmit = (e) =>{
    e.preventDefault();
    const uri = "http://localhost:8080/api/v1/clients";
    const requestBody = this.state;
    delete requestBody.isFormSubmit;
    delete requestBody.response;
    delete requestBody.message;
    console.log(requestBody);

    const requestOptions = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestBody)
    }

    fetch(uri,requestOptions)
      .then(response => {
        console.log(response.status);
        if(response.status!="201"){
          this.setState({
            response: 'danger',
          });
          return;
        }
        return response.json();
      }).then( res =>  {
        console.log(res);
        if(res){
          this.setState({
            response: 'success',
          }); 
        }
      })
      .catch(error => {
        console.log(error);
        this.setState({
          response: 'danger',
        });
      });

      this.setState({
        isFormSubmit: true
      });
  }

  handleInputChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.id;

    this.setState({
      [name]: value
    });

  }

  render(){
    return (
      <>
      {
        this.state.isFormSubmit ?  
        <InformArea 
          result={this.state.response}
          successMessage = "client added!!!"
          failMessage = "something went wrong"
          successLink = {"/clients"} 
          failLink = {"/newClient"} 
        />  
          : 
        <Form 
          title="Client Content" 
          button="Send" 
          formFields={AppConfig.clientAttributes} 
          onSubmit={this.handleSubmit} 
          onChange={this.handleInputChange} 
        /> 
      }
      </>
    );
  }
}

export default NewClientPage;