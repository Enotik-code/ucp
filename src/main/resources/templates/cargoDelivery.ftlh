<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="justify-content-center">
        <h3 class="font-weight-light"> Оформление доставки </h3>
    </div>
    <div class="container">
        <div class="container h-75 bg-info">
            <div id="carouselExampleControls" class="carousel slide " data-interval="false" style="height: 420px" data-ride="carousel">
                <div class="carousel-inner ">
                    <form method="post" action="/cargoDelivery" enctype="multipart/form-data">
                    <div class="carousel-item active">
                        <div class="container mt-3 mb-3 justify-content-center d-flex">
                            <div class="card w-75">
                                <div class="card-body">
                                    <h5 class="card-title font-weight-light">Основная информация <br> о грузе</h5>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Название груза: ${cargo.name}</li>
                                        <li class="list-group-item">Стоимость: ${cargo.cost}</li>
                                        <li class="list-group-item">Вес: ${cargo.weight}</li>
                                        <li class="list-group-item">Объем: ${cargo.capacity}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="container mt-3 mb-3 justify-content-center d-flex">
                            <div class="card w-75" >
                                <div class="card-body">
                                    <h5 class="card-title font-weight-light">Способ доставки и маршрут</h5>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <label for="deliveryType" ><h5 class="font-weight-light ">Способ доставки:</h5></label>
                                        <select class="form-control" name="deliveryType">
                                            <option>Способ доставки</option>
                                            <option>Все</option>
                                            <option>Море</option>
                                            <option>Железная дорога</option>
                                            <option>Авто</option>
                                            <option>Поезд</option>
                                            <option>Воздух</option>
                                            <option>Навалочный груз</option>
                                        </select>
                                    </li>
                                    <li class="list-group-item">
                                        <label for="pickupAddress" ><h5 class="font-weight-light ">Точка А:</h5></label>
                                        <input type="text" class="form-control" name="pickupAddress" placeholder="Откуда - г.Минск">
                                    </li>
                                    <li class="list-group-item">
                                        <label for="deliveryAddress" ><h5 class="font-weight-light ">Точка B:</h5></label>
                                        <input type="text" class="form-control" name="deliveryAddress" placeholder="Куда - г.Гродно">
                                    </li>
                                </ul>
                            </div>
                        </div>

                    </div>
                    <div class="carousel-item">
                        <div class="container mt-3 mb-3 justify-content-center d-flex">
                            <div class="card w-75">
                                <div class="card-body">
                                    <h5 class="card-title font-weight-light">Промежуточные точки</h5>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <label for="addressPointOne" ><h5 class="font-weight-light ">Промежуточная точка 1:</h5></label>
                                        <input type="text" class="form-control" name="addressPointOne" placeholder="г.Воложин">
                                    </li>
                                    <li class="list-group-item">
                                        <label for="addressPointTwo" ><h5 class="font-weight-light ">Промежуточная точка 2:</h5></label>
                                        <input type="text" class="form-control" name="addressPointTwo" placeholder="г.Ивье">
                                    </li>
                                    <li class="list-group-item">
                                        <label for="addressPointThree" ><h5 class="font-weight-light ">Промежуточная точка 3:</h5></label>
                                        <input type="text" class="form-control" name="addressPointThree" placeholder="г.Лида">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="container mt-3 mb-3 justify-content-center d-flex">
                            <div class="card w-75">
                                <div class="card-body">
                                    <h5 class="card-title font-weight-light">Дополнительно</h5>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <label for="distance" ><h5 class="font-weight-light ">Расстояние (км):</h5></label>
                                        <input type="text" class="form-control" name="distance" placeholder="10000">
                                    </li>
                                    <li class="list-group-item">
                                       <label class="form-check-label">
                                            <h5 class="font-weight-light ">Опасный груз <input type="checkbox" name="dangerousCargo"></h5>
                                        </label>
                                    </li>
                                    <li class="list-group-item">
                                        <h5 class="font-weight-light ">еще мб че-та</h5>
                                    </li>
                                    <li class="list-group-item">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                        <div class="form-group">
                                            <button class="btn btn-info" type="submit"><h4>Оформить</h4></button>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>

</@c.page>