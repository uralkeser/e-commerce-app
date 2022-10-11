import React, { Component }  from 'react';
import {Alert} from 'react-bootstrap';
import AppConfig from '../../config/AppConfig';

const InformArea = ({result,successMessage,failMessage,successLink,failLink}) => {
  return (
    <Alert variant={result}>
      <Alert.Heading>{ result == 'success' ? "Success!" : "Error!"}</Alert.Heading>
      <p> { result == 'success' ? successMessage : failMessage}</p>
      <hr />
      <p className="mb-0">
        { 
          result == 'success' ? 
          <Alert.Link href={successLink}>{AppConfig.successAlertLinkPlaceHolder}</Alert.Link> : 
          <Alert.Link href={failLink}>{AppConfig.failAlertLinkPlaceHolder}</Alert.Link>}
      </p>
    </Alert>
  );
}

export default InformArea;