package br.com.jhegner.labs.dp.gof.observer.exemplo1

class Publisher
    (var subscriber: List<Subscriber>)
{

    constructor(var subscriber: List<Subscriber>) : this(name)

    fun publicarEvento() {
        subscriber.forEach{
            it.update(Context("Joao", 25))
        }
    }
}