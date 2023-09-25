/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.BlogCategory;

/**
 *
 * @author kienk
 */
public class BlogDAO extends DBContext {
    public List<BlogCategory> getListBlogCategory(){
        List<BlogCategory> list = new ArrayList<>();
        String query = "Select * from [DURIAN_SHOP].[dbo].[BlogCategory]";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new BlogCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public List<BlogCategory> getListBlogCategory(int status){
        List<BlogCategory> list = new ArrayList<>();
        String query = "Select * from [DURIAN_SHOP].[dbo].[BlogCategory] where [status]=" + status;
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new BlogCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Blog> getListBlogbyCategoryId(int id){
        List<Blog> list = new ArrayList<>();
        String query = "Select * from [DURIAN_SHOP].[dbo].[Blog] where categoryId = "+ id;
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Blog(rs.getInt(1), rs.getNString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Blog> getListBlogbyCategoryId(int id, int status){
        List<Blog> list = new ArrayList<>();
        String query = "Select * from [DURIAN_SHOP].[dbo].[Blog] where categoryId = "+ id + " and [status]=" + status;
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Blog(rs.getInt(1), rs.getNString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public BlogCategory getBlogCategoryById(int id){
        String query = "Select * from [DURIAN_SHOP].[dbo].[BlogCategory] where id = " + id;
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new BlogCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public int createBlogCategory(String name){
        int isSuccess = 0;
        String query = "Insert into [DURIAN_SHOP].[dbo].[BlogCategory](categoryName, status) values (?, 1)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            isSuccess = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return isSuccess;
    }
    
    public int updateBlogCategory(int id, String name, int status){
        int success = 0;
        String query = "UPDATE [BlogCategory] SET " +
                                       "status = " + status;
        if (!name.equals("")){
            query+= ", categoryName = '" + name + "' ";
        }
        query += " where id = " + id;
          try{
            PreparedStatement ps = connection.prepareStatement(query);
            success = ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            System.out.println(e);
        }
          return success;
    }
    
    public int updateBlog(int id, String title, int status, int catgoryId){
        int success = 0;
        String query = "UPDATE [Blog] SET " +
                                       "status = " + status;
        if (!title.equals("")){
            query+= ", title = '" + title + "' ";
        }
        if (catgoryId != 0){
            query+= ", categoryId = " + catgoryId;
        }
        query += " where categoryId = " + id;
          try{
            PreparedStatement ps = connection.prepareStatement(query);
            success = ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            System.out.println(e);
        }
          return success;
    }
    
    public static void main(String[] args) {
        BlogDAO bd = new BlogDAO();
        List<Blog> list = bd.getListBlogbyCategoryId(1);
        for (Blog blog : list) {
            System.out.println(blog.getStatus());
        }
    }
   
}
