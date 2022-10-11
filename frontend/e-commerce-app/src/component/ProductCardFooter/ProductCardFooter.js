import React, { Component }  from 'react';
import ListGroup from 'react-bootstrap/ListGroup';

function ProductCardFooter({product}) {
  return (
    <ListGroup className="list-group-flush">
        <ListGroup.Item>{product.vendorUserId}</ListGroup.Item>
        <ListGroup.Item>{product.categoryId}</ListGroup.Item>
    </ListGroup>
  );
}

export default ProductCardFooter;
