import Card from 'react-bootstrap/Card';
import ProductCardFooter from '../ProductCardFooter/ProductCardFooter'; 

function ProductCard({product,showDetail}) {
  return (
    <Card style={showDetail? {width: '40rem'} : {width: '18rem'}}>
      <Card.Img variant="top" src={product.imageUrl} style={{ }} />
      <Card.Body>
        <Card.Title>{product.name}</Card.Title>
        <Card.Text>
          {product.price} TL
        </Card.Text>
      </Card.Body>
      <> { showDetail? <ProductCardFooter product={product}/> : null} </>
      
    </Card>
  );
}

export default ProductCard;