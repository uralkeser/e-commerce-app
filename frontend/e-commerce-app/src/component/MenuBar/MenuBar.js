import {Navbar, Container, Nav, NavDropdown} from 'react-bootstrap';

const MenuBar = (props) =>{
  return(
    <Navbar bg="primary" expand="lg">
    <Container >
        <Navbar.Brand href="/">eCommerce Management Tool</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
                <NavDropdown title="Products" id="basic-nav-dropdown">
                  <NavDropdown.Item href="/products">all products</NavDropdown.Item>
                  <NavDropdown.Item href="/newProduct">new product</NavDropdown.Item>
                  {/* <NavDropdown.Item href="/updatedProducts">update product</NavDropdown.Item> */}
                </NavDropdown>
                <NavDropdown title="Clients" id="basic-nav-dropdown">
                <NavDropdown.Item href="/clients">all clients</NavDropdown.Item>
                  <NavDropdown.Item href="/newClient">new client</NavDropdown.Item>
                  {/* <NavDropdown.Item href="/updatedClient">update client</NavDropdown.Item> */}
                </NavDropdown>
                <NavDropdown title="Categories" id="basic-nav-dropdown">
                  <NavDropdown.Item href="/categories">all categories</NavDropdown.Item>
                  <NavDropdown.Item href="/newCategory">new category</NavDropdown.Item>
                </NavDropdown>
            </Nav>
        </Navbar.Collapse>
    </Container>
    </Navbar>
  )
}

export default MenuBar;