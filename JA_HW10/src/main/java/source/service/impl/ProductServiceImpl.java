package source.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import source.DAO.ProductDao;
import source.DAO.Impl.ProductDaoImpl;
import source.domain.Product;
import source.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private static ProductService productServiceImpl;

	private ProductServiceImpl() {
			productDao = new ProductDaoImpl();
	}

	public static ProductService getProductService() {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}
		return productServiceImpl;
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Map<Integer, Product> readAllMap() {
        return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
