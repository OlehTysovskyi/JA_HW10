package source.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import source.domain.Bucket;
import source.domain.Product;
import source.domain.User;
import source.service.BucketService;
import source.service.ProductService;
import source.service.UserService;
import source.service.impl.BucketServiceImpl;
import source.service.impl.ProductServiceImpl;
import source.service.impl.UserServiceImpl;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private ProductService productService = ProductServiceImpl.getProductService();
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productId");

		Product product = productService.read(Integer.parseInt(productId));

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userService.read(userId);

		Bucket bucket = new Bucket();
		bucket.setId(UUID.randomUUID().toString());
		bucket.setProduct(product);
		bucket.setUser(user);
		bucket.setPurchaseDate(new Date());

		bucketService.create(bucket);

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}