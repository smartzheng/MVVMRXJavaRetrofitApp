package com.bar.mvvmapp.model.Bean;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by smartzheng on 2017/9/12.
 */

public class MovieBean {
    private int count;//请求的个数
    private int start;
    private String title;
    private int total;//总数
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        private String alt;
        private int collect_count;
        private String id;
        private ImagesBean images;
        private String original_title;
        private Rating rating;
        private String subtype;
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
        public String getCastsString() {
            return casts2StringBySlash(casts);
        }

        public String getDirectorsString() {
            return directors2StringBySlash(directors);
        }

        private List<String> genres;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public Rating getRating() {
            return rating;
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public static class ImagesBean {
            /**
             * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2460006593.webp
             * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2460006593.webp
             * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2460006593.webp
             */

            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }

        public static class Rating {
            /**
             * average : 8
             * max : 10
             * min : 0
             * stars : 40
             */

            private double average;
            private double max;
            private double min;
            private String stars;

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public double getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }
        }
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1054395/
         * avatars : {"large":"https://img1.doubanio.com/img/celebrity/large/51597.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51597.jpg","small":"https://img1.doubanio.com/img/celebrity/small/51597.jpg"}
         * id : 1054395
         * name : 伊利亚·伍德
         */

        private String alt;
        private AvatarsBean avatars;
        private String id;
        private String name;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class AvatarsBean {
            /**
             * large : https://img1.doubanio.com/img/celebrity/large/51597.jpg
             * medium : https://img1.doubanio.com/img/celebrity/medium/51597.jpg
             * small : https://img1.doubanio.com/img/celebrity/small/51597.jpg
             */

            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1276787/
         * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg"}
         * id : 1276787
         * name : 申·阿克
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String id;
        private String name;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class AvatarsBeanX {
            /**
             * large : https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg
             * medium : https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg
             * small : https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg
             */

            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
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
