package com.pattern.service;

public interface ShoppingCartVisitor {

	int visit(Book book);

	int visit(Fruit fruit);
}