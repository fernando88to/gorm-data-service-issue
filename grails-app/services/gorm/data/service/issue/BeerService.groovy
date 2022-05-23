package gorm.data.service.issue

import grails.gorm.services.Service

@Service(Beer)
interface BeerService {

    Beer get(Serializable id)

    List<Beer> list(Map args)

    Long count()

    Beer delete(Serializable id)

    Beer save(Beer beer)

}
