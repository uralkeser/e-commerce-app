import React from "react";
import ProductCard from "../component/ProductCard/ProductCard";

class ProductsPage extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      products : []
    };
  }

  componentDidMount(){

    const uri = "http://localhost:8080/api/v1/products/allProducts";

    fetch(uri) 
    .then((response) => response.json())
    .then((jsonResponse) => {
      console.log(jsonResponse);
      this.setState({products : jsonResponse});   
    }).catch((err) => console.log(err));
  }

  render(){
    return (
      <div style={{ display: 'flex' , flexDirection: 'row', justifyContent: 'center' }}>
      {
        this.state.products.map((product) => {
          return(
            <ProductCard product = {product} key={product.name} showDetail={false}/>
          )      
        })
      }
      </div>
    );
  }
}

export default ProductsPage;