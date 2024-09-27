package br.com.fiap.bookApi.model;

public class Livro {
    private String title;
    private String authors;
    private String description;
    public String getAuthors(){
        return authors;
    }

    public void setAuthors(String authors){
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Livro{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", description='" + description + '\'' +

                '}';
    }
}
