package gorm.data.service.issue

import grails.util.Holders
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class BeerController {

    BeerService beerService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond beerService.list(params), model:[beerCount: beerService.count()]
    }

    def show(Long id) {
        respond beerService.get(id)
    }

    @Transactional
    def save(Beer beer) {
        if (beer == null) {
            render status: NOT_FOUND
            return
        }
        if (beer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond beer.errors
            return
        }

        try {
            beerService.save(beer)
        } catch (ValidationException e) {
            respond beer.errors
            return
        }

        respond beer, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Beer beer) {
        if (beer == null) {
            render status: NOT_FOUND
            return
        }
        if (beer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond beer.errors
            return
        }

        try {
            beerService.save(beer)
        } catch (ValidationException e) {
            respond beer.errors
            return
        }

        respond beer, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || beerService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
