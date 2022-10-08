import React from 'react'; 
// import serialize from 'form-serialize';
import InformArea from '../component/InformArea/InformArea';
import ApplicationForm from '../component/ApplicationForm/ApplicationForm';

class NewClientPage extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      isFormSubmit: false,
      response: 'success',
      message: ''
    }
  }  

  handleFormSubmit = (e) =>{
    e.preventDefault();
  
    //const newClient = serialize(e.target, {hash:true})

    const uri = "http://localhost:8080/api/v1/clients";

    const requestOptions = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify()
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

  render(){
    return (
      <>
      {
        this.state.isFormSubmit ?  
        <InformArea 
          type="client-result" 
          result={this.state.response} 
          successLink={"/clients"} 
          failLink={"/newClient"} 
        />  
          : 
        <ApplicationForm 
          title="Info" 
          button="Send" 
          formItems={null} 
          onSubmit={this.handleSubmit} 
          onChange={this.handleInputChange} 
        /> 
      }
      </>
    );
  }
}

export default NewClientPage;