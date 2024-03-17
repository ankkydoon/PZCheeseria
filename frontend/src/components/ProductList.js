import React, {useContext, useEffect,useState} from 'react';
import ProductTableRow from "./ProductTableRow";
import { ProductContext } from "../context/ProductContext";
import { getProducts } from "../services/ApiService"
import {NavLink} from "react-router-dom";

export default function ProductList() {

  const { products, updateProducts } = useContext(ProductContext);
  const [sumItems, setTotal] = useState(0);
  const totalUpdate = (sumItem) => {
    setTotal(sumItem);
  };

  useEffect(() => {
    async function fetchData() {
      try {
        const products = await getProducts();
        updateProducts(products);
        let sumItems = products.map(item => item.total).reduce((a, b) => a + b)
        totalUpdate(sumItems)
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    }

    fetchData();
  }, []);

  return(
    <div>
      <nav aria-label="breadcrumb">
        <ol className="breadcrumb">
          <li className="breadcrumb-item">
            <NavLink to="/">Home</NavLink>
          </li>
        </ol>
      </nav>
      <table className="table table-striped">
        <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Image</th>
          <th scope="col">Title</th>
          <th scope="col">Price</th>
          <th scope="col">Quantity</th>
          <th scope="col">Total</th>
          <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        {products.map(product => <ProductTableRow key={product.id} {...product} />)}
        </tbody>
      </table>
      <div>
        <tr>Total: $ {sumItems} </tr>
      </div>
    </div>

  );

}