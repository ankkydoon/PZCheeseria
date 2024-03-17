import { NavLink } from "react-router-dom";

export default function ProductTableRow ({id,imgUrl, title, price, quantity , total}) {

  return(
      <tr>
          <th scope="row">{id}</th>
          <td><img src={imgUrl} width="200" height="100"/></td>
          <td>{title}</td>
          <td>${price}</td>
          <td>{quantity}</td>
          <td>${total}</td>
          <td>
              <div className="btn-group">
                  <NavLink className="btn btn-info" to={`/${id}`}>View</NavLink>
                  <NavLink className="btn btn-light" to={`/${id}/edit`}>Select</NavLink>
              </div>
          </td>
      </tr>
  );
}