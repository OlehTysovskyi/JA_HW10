package source.service.impl;

import java.util.List;

import source.DAO.BucketDao;
import source.DAO.Impl.BucketDaoImpl;
import source.domain.Bucket;
import source.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private BucketDao bucketDao;
	private static BucketService bucketServiceImpl;

	private BucketServiceImpl() {
			bucketDao = new BucketDaoImpl();
	}

	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}
		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket bucket) {
		return bucketDao.create(bucket);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket bucket) {
		return bucketDao.update(bucket);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}
}
