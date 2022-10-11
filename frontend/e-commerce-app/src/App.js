import React, {Component} from "react";
import {Route, Routes} from "react-router-dom";
import AppConfig from "./config/AppConfig";
import Navbar from "./component/MenuBar/MenuBar";
import Footer from "./component/Footer/Footer";
import HomePage from "./pages/HomePage";
import ProductsPage from "./pages/ProductsPage";
import ClientsPage from "./pages/ClientsPage";
import NewClientPage from "./pages/NewClientPage";
import NewProductPage from "./pages/NewProductPage";
import CategoriesPage from "./pages/CategoriesPage";
import NewCategoryPage from "./pages/NewCategory";

class App extends Component {
  render(){
    return (
      <div className="container" >
        <Navbar/>
        <Routes>
          <Route path="/" element={<HomePage></HomePage>}/>
          <Route path={AppConfig.allProductsPath} element={<ProductsPage></ProductsPage>}/>
          <Route path={AppConfig.newProductPath} element={<NewProductPage></NewProductPage>}/>
          {/* <Route path="/updatingProduct" element={<ProductsPage></ProductsPage>}/> */}

          <Route path={AppConfig.allClientsPath} element={<ClientsPage></ClientsPage>}/>
          <Route path={AppConfig.newClientPath} element={<NewClientPage></NewClientPage>}/>
          {/* <Route path="/updatingClient" element={<ProductsPage></ProductsPage>}/> */}

          <Route path={AppConfig.allCategoriesPath} element={<CategoriesPage></CategoriesPage>}/>
          <Route path={AppConfig.newCategoryPath} element={<NewCategoryPage></NewCategoryPage>}/>

        </Routes>
        <Footer/>
      </div>
    );
  }
}

export default App;
