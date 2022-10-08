import {Alert} from 'react-bootstrap';

const InformArea = ({result,successMessage,failMessage,successLink,failLink}) => {
  return (
    <Alert result={result}>
      <Alert.Heading>{ result == 'success' ? "Success!" : "Error!"}</Alert.Heading>
      <p>
        { result == 'success' ? successMessage : failMessage}
      </p>
      <hr />
      <p className="mb-0">
        { result == 'success' ? <Alert.Link href={successLink}>Show All Clients</Alert.Link> : <Alert.Link href={failLink}>New Client</Alert.Link> }.
      </p>
    </Alert>
  );
}

export default InformArea;