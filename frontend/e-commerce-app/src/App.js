import {React, Component} from "react";
import {Route, Routes} from "react-router-dom";
import Navbar from "./component/MenuBar/MenuBar";
import Footer from "./component/Footer/Footer";
import ProductsPage from "./pages/ProductsPage";
import ClientsPage from "./pages/ClientsPage";
import NewClientPage from "./pages/NewClientPage";

class App extends Component {
  render(){
    return (
      <div className="container">
        <Navbar/>
        <Routes>
          <Route path="/products" element={<ProductsPage></ProductsPage>}/>
          {/* <Route path="/newProduct" element={<NewProductPage></NewProductPage>}/> */}
          {/* <Route path="/updatedProduct" element={<ProductsPage></ProductsPage>}/> */}

          <Route path="/clients" element={<ClientsPage></ClientsPage>}/>
          <Route path="/newclient" element={<NewClientPage></NewClientPage>}/>
          <Route path="/updatedclient" element={<ProductsPage></ProductsPage>}/>
          
          <Route path="/newCategory" element={<ProductsPage></ProductsPage>}/>
        </Routes>
        <Footer/>
      </div>
    );
  }
}

export default App;
