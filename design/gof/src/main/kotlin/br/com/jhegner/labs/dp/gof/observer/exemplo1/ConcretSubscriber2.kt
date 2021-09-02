package br.com.jhegner.labs.dp.gof.observer.exemplo1

class ConcretSubscriber2 : Subscriber {

    override fun update(user: Context) {
        println("Executando o subscriber 2")
    }
}