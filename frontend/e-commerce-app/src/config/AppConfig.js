module.exports = {
    clientAttributes:["fullName","userName","password","mail","mobileNumber"],
    productAttributes:["name","imageUrl","price","discount","categoryId","vendorUserId"],
    categoryAttributes:["name"],
    
    allClientsPath : "/clients",
    newClientPath : "/newClient" ,

    allProductsPath : "/products",
    newProductPath : "/newProduct" ,

    allCategoriesPath : "/categories",
    newCategoryPath : "/newCategory" ,
    
    clientURI: "http://localhost:8080/api/v1/clients",
    productsURI: "http://localhost:8080/api/v1/products",
    categoryURI:"http://localhost:8080/api/v1/categories",
    
    clientFormTitle: "Client Information",
    productFormTitle: "Product Information",
    categoryFormTitle: "Category Information" ,
    
    successMessage : "insertion successful",
    failMessage : "something went wrong",
    sendButtonPlaceHolder:"Send" ,
    
    successAlertLinkPlaceHolder:"Show all",
    failAlertLinkPlaceHolder:"Try again",

}