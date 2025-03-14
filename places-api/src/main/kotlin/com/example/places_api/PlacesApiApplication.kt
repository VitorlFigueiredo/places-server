package com.example.places_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class PlacesApiApplication

fun main(args: Array<String>) {
	runApplication<PlacesApiApplication>(*args)
}

@RestController
@RequestMapping("/biped")
class BipedController {

	@GetMapping
	fun telaInicial(): String {
		return "Seja bem-vindo ao grupo Biped!"
	}

	@GetMapping("/app/{nameApp}")
	fun nomeApp(@PathVariable nameApp: String): String {
		return "O nome do app é: $nameApp"
	}

	@GetMapping("/app/{nameApp}/description/{description}")
	fun nameAppAndDescription(
		@PathVariable nameApp: String,
		@PathVariable description: String
	): String {
		return "O nome do app é: $nameApp e sua descrição é: $description"
	}

	@GetMapping("/premium")
	fun premiumPlus(
		@RequestParam name: String,
		@RequestParam validity: Int
	): String {
		return "$name, Seja bem-vindo à nossa consultoria premium! Seu períoldo de teste expira em $validity dias."
	}

	@GetMapping("/{id}")
	fun createNewAppInfo(@PathVariable id: String): ResponseEntity<AppInfo> {
		 val appInfo = AppInfo(
			id,
			 "Vitin",
			"Seu toba",
			 "90"
		)
		return ResponseEntity.status(HttpStatus.CREATED).body(appInfo)
	}

	@PostMapping("/infosapp")
	fun infosApp(@RequestBody appInfo: AppInfo): String{
		return "Seu aplicativo foi criado com sucesso!" +
				"Seu login é: ${appInfo.login}" +
				"Sua pontuação é: ${appInfo.pontuacao}" +
				"Seu plano premium expira em ${appInfo.diasRestantes} dias"
	}
}

data class AppInfo(
	val id:String?,
	val login : String,
   	val pontuacao : String,
    val diasRestantes : String
)




