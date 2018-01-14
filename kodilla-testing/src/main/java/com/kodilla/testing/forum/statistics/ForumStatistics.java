package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostsAnUser;
    private double averageCommentsAnUser;
    private double averageCommentsAnPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        if (postsQuantity != 0 && usersQuantity != 0 ) {
            averagePostsAnUser = (double) postsQuantity / usersQuantity;
        }
        if (commentsQuantity != 0 && usersQuantity != 0) {
            averageCommentsAnUser = (double) commentsQuantity / usersQuantity;
        }
        if (commentsQuantity != 0 && postsQuantity != 0) {
            averageCommentsAnPost = (double) commentsQuantity / postsQuantity;
        }
    }

    public void showStatistics() {
        System.out.println("Ilość użytkowników --> " + usersQuantity);
        System.out.println("Ilość postów --> " + postsQuantity);
        System.out.println("Ilość komentarzy --> " + commentsQuantity);
        System.out.printf("Średnia ilość postów na użytkownika --> " + "%5.2f", averagePostsAnUser);
        System.out.printf("\nŚrednia ilość komentarzy na użytkownika --> " + "%5.2f", averageCommentsAnUser);
        System.out.printf("\nŚrednia ilość komentarzy na post --> " + "%5.2f", averageCommentsAnPost);
        System.out.println();

    }

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }
}