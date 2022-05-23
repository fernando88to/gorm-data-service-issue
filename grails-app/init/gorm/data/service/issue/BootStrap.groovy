package gorm.data.service.issue

import grails.gorm.transactions.Transactional

class BootStrap {


    /**
     * Create an initial record
     */
    @Transactional
    void saveInit(){
        def beer1 = new Beer(name:'teste')
        beer1.save(flush:true)
    }

    def init = { servletContext ->
        saveInit()

    }
    def destroy = {
    }
}
