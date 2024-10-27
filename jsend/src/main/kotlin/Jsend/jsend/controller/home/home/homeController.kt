package Jsend.jsend.controller.home.home

import Jsend.jsend.model.Model
import Jsend.jsend.response.ErrorResponse
import Jsend.jsend.response.SuccessResponse
import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/*  @GetMapping("/{id}")
    fun home (@PathVariable("id") id: Int): String{
        return  "Hello word $id"
    }
}

    @GetMapping
    fun home (@PathParam("id") id: Int): String{
        return  "Hello word $id"
@GetMapping
fun home (@RequestBody(mode: model): String{
    return  "Hello word ${model.id} ${model.name} ${model.age}"
}
}    }
}*/
@GetMapping("/home")
fun home (@RequestBody model: SuccessResponse):SuccessResponse{
    return SuccessResponse().apply {
        status = "success"
        data = model
    }
}
@GetMapping("/failed")
fun getModel (@RequestBody model: SuccessResponse):SuccessResponse{
    return SuccessResponse().apply {
        status = "failed"
        data = "El campo edad esta vacio"
    }
}

@GetMapping("/error")
fun getError (@RequestBody model: ErrorResponse):ErrorResponse{
    return ErrorResponse().apply {
        status = "error"
        message = "Unable to communicate with database"
    }
}

@RestController
@RequestMapping("/home")
class homeController {
}