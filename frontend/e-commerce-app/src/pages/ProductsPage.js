import React from "react";
import ProductCard from "../component/ProductCard/ProductCard";
class ProductsPage extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      products : [{
        name: "aaaaa",
        imageUrl: "https://n11scdn.akamaized.net/a1/%7B0%7D/elektronik/cep-telefonu/apple-iphone-13-512-gb-apple-turkiye-garantili__1148267101141060.jpg",
        price: 1,
        discount: 11,
        categoryId: 111,
        vendorUserId: 1111
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