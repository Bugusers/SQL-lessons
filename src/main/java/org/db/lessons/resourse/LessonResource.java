package org.db.lessons.resourse;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.db.lessons.model.dto.LessonDTO;
import org.db.lessons.service.LessonService;
import java.util.List;

@Path("lessons")
public class LessonResource {
    @Inject
    private LessonService lessonService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLessons() {
        List<LessonDTO> lessons = lessonService.getAllLessons();
        return Response.status(Response.Status.OK).entity(lessons).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLessonById(@PathParam("id") Long id) {
        LessonDTO lesson = lessonService.getLessonById(id);
        return Response.status(Response.Status.OK).entity(lesson).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLesson(LessonDTO lesson) {
        LessonDTO createdLesson = lessonService.createLesson(lesson);

        return Response.status(Response.Status.CREATED).entity(createdLesson).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLesson(@PathParam("id") Long id) {
        lessonService.deleteLesson(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLesson(@PathParam("id") Long id, LessonDTO lesson) {
        lesson.setId(id);
        LessonDTO updatedLesson = lessonService.updateLesson(lesson);
        return Response.status(Response.Status.OK).entity(updatedLesson).build();
    }
}