package DemoRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path(value = "RestBooks")
public class BookController {

    BookService bd = BookService.getInstance();

    @GET
    @Path("/getList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookModel> list(){
       return bd.listAll();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        BookModel book = bd.get(id);
        if (book != null) {
            return Response.ok(book, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(BookModel book) throws URISyntaxException, URISyntaxException {
        int newBookId = bd.add(book);
        URI uri = new URI("/RestBooks/" + newBookId);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, BookModel book) {
        book.setId(id);
        if (bd.update(book)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        if (bd.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

}
