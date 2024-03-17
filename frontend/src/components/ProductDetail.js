import React, {useEffect, useContext} from "react";
import {NavLink, useParams, useNavigate} from "react-router-dom";
import {ProductContext} from "../context/ProductContext";
import {getProductById} from "../services/ApiService"

export default function ProductDetail() {

  const { id } = useParams();
  const { product, updateProduct, removeProductById } = useContext(ProductContext);
  const navigate = useNavigate();

  useEffect(() => {

    async function fetchData() {
      try {
        const product = await getProductById(id);
        updateProduct(product);
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
            <NavLink to="/">Products</NavLink>
          </li>
          <li className="breadcrumb-item">
            <NavLink active to={`/${id}`}>{id}</NavLink>
          </li>
        </ol>
      </nav>
      <h4 className="text-center mb-5 mt-5">Product Info: {id}</h4>
      <table className="table">
        <tbody>
        <tr>
          <th scope="row">Title</th>
          <td>{product.title}</td>
        </tr>
        <tr>
          <th scope="row">Price</th>
          <td>AUD ${product.price}</td>
        </tr>
        <tr>
          <th scope="row">Quantity</th>
          <td>{product.quantity}</td>
        </tr>
        <tr>
          <th scope="row" align ="right">Total</th>
          <td>{product.total}</td>
        </tr>
        </tbody>
      </table>
      <div>
        <div className="row">
          <div className="col-6">
          <NavLink className="btn btn-light" to={`/${id}/edit`}>Select</NavLink>
          </div>
        </div>
      </div>
    </div>
  );

}