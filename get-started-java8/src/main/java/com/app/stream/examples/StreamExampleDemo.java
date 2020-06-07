package com.app.stream.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.app.dto.ProductDetail;

public class StreamExampleDemo {

	public static void main(String[] args) {

		List<ProductDetail> productList = new ArrayList<ProductDetail>();

		ProductDetail product1 = new ProductDetail(1L, "Product1", 23.80F, "HOME APPLIANCE");
		ProductDetail product4 = new ProductDetail(4L, "Product1", 26.80F, "HOME APPLIANCE");

		ProductDetail product2 = new ProductDetail(2L, "Product1", 24.80F, "ELECTRONICS");
		ProductDetail product3 = new ProductDetail(3L, "Product1", 1000F, "ELECTRONICS");
		ProductDetail product5 = new ProductDetail(5L, "Product1", 27.80F, "ELECTRONICS");

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);

		// productList.stream().

		// 1. Find the product with highest price
		/*
		 * productList.sort( new Comparator<ProductDetail>() {
		 * 
		 * @Override public int compare(ProductDetail productFirst, ProductDetail
		 * productTwo) { int result =
		 * productFirst.getPrice().compareTo(productTwo.getPrice()); if (result < 0) {
		 * result = 1; } else if (result > 0) { result = -1; } return result; } });
		 */

		/*
		 * productList.sort((item1, item2) -> { int result =
		 * item1.getPrice().compareTo(item2.getPrice()); if (result < 0) { result = 1; }
		 * else if (result > 0) { result = -1; } return result; });
		 * 
		 * System.out.println(productList.get(0)); System.out.println(productList);
		 * 
		 * Double sum = productList.stream().collect(Collectors.summingDouble((product)
		 * -> { return product.getPrice(); }));
		 */

		ProductDetail maxPrice = productList.stream().max((ProductDetail obj1, ProductDetail obj2) -> {
			return obj1.getPrice().compareTo(obj2.getPrice());
		}).orElse(null);

		System.out.println("max: " + maxPrice);

		ProductDetail minPrice = productList.stream().min((ProductDetail obj1, ProductDetail obj2) -> {
			return obj1.getPrice().compareTo(obj2.getPrice());
		}).orElse(null);

		System.out.println("min: " + minPrice);

		Map<String, List<ProductDetail>> map = productList.stream()
				.collect(Collectors.groupingBy(ProductDetail::getType));

		map.entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey() + "  :   " + entry.getValue());
		});

		List<String> alphabets = new ArrayList<String>();
		alphabets.add("A");
		alphabets.add("B");
		alphabets.add(null);
		alphabets.add("D");
		alphabets.add("E");

		String commaSeperatedStr = alphabets.stream().map(item -> {
			if (Objects.isNull(item)) {
				return "";
			}
			return item;
		}).map(Object::toString).collect(Collectors.joining(","));
		System.out.println("commaSeperatedStr  : " + commaSeperatedStr);

		Map<String, Optional<ProductDetail>> sortedMap = productList.stream().collect(
				Collectors.groupingBy(ProductDetail::getType, Collectors.maxBy(new Comparator<ProductDetail>() {
					@Override
					public int compare(ProductDetail o1, ProductDetail o2) {
						return o1.getPrice().compareTo(o2.getPrice());
					}
				})));

		sortedMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + "  :   " + entry.getValue());
		});

		Map<String, DoubleSummaryStatistics> sumOfPriceMap = productList.stream().collect(
				Collectors.groupingBy(ProductDetail::getType, Collectors.summarizingDouble(ProductDetail::getPrice)));
		// System.out.println(sumOfPriceMap);
		sumOfPriceMap.entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey() + "    : " + entry.getValue().getSum());
		});
		
		Map<Boolean, List<ProductDetail>> 	 partitionMap=productList.stream().collect(Collectors.partitioningBy(new Predicate <ProductDetail>() {
			@Override
			public boolean test(ProductDetail object) {
				return "HOME APPLIANCE".equalsIgnoreCase(object.getType())?true:false;
			}
		}));
		
		partitionMap.entrySet().stream().forEach(entry->{
			System.out.println(entry.getKey() + "    : " + entry.getValue());
		});
		
	}
}
