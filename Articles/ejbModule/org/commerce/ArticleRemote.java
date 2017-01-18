package org.commerce;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ArticleRemote {

	public Article createArticle(String designation, String categorie, String description, double prix, int stock);
	
	public List<Article> getAllArticle();
	public List<Article> getArticle(String type);
	public List<Article> getArticlePanier(List<Integer> id);
	void MaJStockArticle(int id, int stock);
	public Article getSingleArticle(int id);
}
