package lab12.controllers;

import com.google.gson.Gson;
import lab12.dto.IdParameter;
import lab12.models.CartItem;
import lab12.models.Product;
import lab12.storage.ApplicationStorage;
import lab12.storage.StorageType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int prodId = Integer.parseInt(request.getParameter("id"));
        List<Product> productsStore = ApplicationStorage.getInstance(request, response).getValue(StorageType.Application, "products");

        Product product = productsStore.stream().filter(p -> p.getId() == prodId).findFirst().get();
        String json = new Gson().toJson(product);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
