package com.system.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.bean.Movie;
import com.system.bean.Moviepoint;
import com.system.bean.Userinf;
import com.system.dao.MoviepointDao;
import com.system.dao.UserinfDao;

@Service
public class RecommondService {
    
    
    @Autowired
    UserinfDao infMapper;
    
    @Autowired
    MoviepointDao moviepointDao;
    
    public List<String> getMoviesById(String id) {
        List<String> ans = new ArrayList<String>();
        List<Moviepoint> ans1 = new ArrayList<Moviepoint>();
//        ans.add("1");
//        ans.add("2");
//        ans.add("3");
        ans1 = moviepointDao.getmoviesbyPoint();
        for(Moviepoint movie : ans1) {
            ans.add(movie.getId());
        }
        return ans;
    }
    
    public List<String> getMoviesByItem(String id) throws Exception {
        List<String> ans = new ArrayList<String>();
        
        List<RecommendedItem> recommendations = null;

        int length=(int)((Math.random()+3)*10);
        String file = "D:\\j2eeworkspace\\MovieTry\\datafile\\rua.csv";
        DataModel model = new FileDataModel(new File(file));
        UserSimilarity user = new PearsonCorrelationSimilarity(model);
        
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(length, user, model);
        
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);
        
        recommendations = r.recommend(Integer.valueOf(id), length);
        for (RecommendedItem ritem : recommendations) {               
            //System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
            ans.add(ritem.getItemID() + "");
        }
        
        return ans;
    }
    
    public List<String> getMoviesByUser(String id) throws Exception {
        List<String> ans = new ArrayList<String>();
        List<RecommendedItem> recommendations = null;

        int length=(int)((Math.random()+3)*10);
        String file = "D:\\j2eeworkspace\\MovieTry\\datafile\\rua.csv";
        DataModel model = new FileDataModel(new File(file));
        UserSimilarity user = new PearsonCorrelationSimilarity(model);
        
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(length, user, model);
        
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);
        
        recommendations = r.recommend(Integer.valueOf(id), length);
        for (RecommendedItem ritem : recommendations) {               
            //System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
            ans.add(ritem.getItemID() + "");
        }
        
        
        return ans;
    }
}
