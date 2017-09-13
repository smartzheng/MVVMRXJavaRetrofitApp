package com.bar.mvvmapp.model.Bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by smartzheng on 2017/9/12.
 * 这里使用GsonFormat自动生成，databinding还提供了可以免去写set/get方法的写法，统一格式，很简单，这里不实现了
 */

public class MovieBean extends BaseObservable{
    private int count;//请求的个数
    private int start;
    private String title;
    private int total;//总数
    private List<SubjectsBean> subjects;
    @Bindable
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Bindable
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Bindable
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    @Bindable
    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean extends BaseObservable{

        private ImagesBean images;
        private Rating rating;
        private String title;
        private String year;
        private List<CastsBean> casts;
        private String castsString;
        private List<DirectorsBean> directors;
        private String directorsString;
        @BindingAdapter({"imageUrl"})
        public static void loadImage(ImageView imageView, String url) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);

        }
        @Bindable
        public String getCastsString() {
            return casts2StringBySlash(casts);
        }
        @Bindable
        public String getDirectorsString() {
            return directors2StringBySlash(directors);
        }


        @Bindable
        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }


        @Bindable
        public Rating getRating() {
            return rating;
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }

        @Bindable
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        @Bindable
        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
        @Bindable
        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }
        @Bindable
        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }


        public static class ImagesBean extends BaseObservable{
            /**
             * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2460006593.webp
             * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2460006593.webp
             * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2460006593.webp
             */

            private String large;

            @Bindable
            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

        }

        public static class Rating extends BaseObservable{

            private float average;

            @Bindable
            public float getAverage() {
                return average;
            }

            public void setAverage(float average) {
                this.average = average;
            }

        }
    }

    public static class CastsBean extends BaseObservable {
        /**
         * alt : https://movie.douban.com/celebrity/1054395/
         * avatars : {"large":"https://img1.doubanio.com/img/celebrity/large/51597.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51597.jpg","small":"https://img1.doubanio.com/img/celebrity/small/51597.jpg"}
         * id : 1054395
         * name : 伊利亚·伍德
         */

        private String name;

        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class DirectorsBean extends BaseObservable{
        /**
         * alt : https://movie.douban.com/celebrity/1276787/
         * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg"}
         * id : 1276787
         * name : 申·阿克
         */


        private String name;

        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
    public static String directors2StringBySlash(List<DirectorsBean> list) {
        String s = "";
        for (DirectorsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "导演: 暂无";
        }
        return "导演: " + s.substring(0, s.length() - 1);
    }


    /**
     * 连接演员
     * @param list
     * @return
     */
    public static String casts2StringBySlash(List<CastsBean> list) {
        String s = "";
        for (CastsBean item : list) {
            s += item.getName() + "/";
        }
        if (s.equals("")) {
            return "演员: 暂无";
        }
        return "演员: " + s.substring(0, s.length() - 1);
    }

}
