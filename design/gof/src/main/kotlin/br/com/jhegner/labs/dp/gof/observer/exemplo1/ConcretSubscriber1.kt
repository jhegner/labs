package br.com.jhegner.labs.dp.gof.observer.exemplo1

class ConcretSubscriber1 : Subscriber {

    override fun update(user: Context) {
        println("Executando o subscriber 1")
    }
}