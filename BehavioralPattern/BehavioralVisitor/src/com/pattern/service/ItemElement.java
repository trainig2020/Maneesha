package com.pattern.service;

public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}