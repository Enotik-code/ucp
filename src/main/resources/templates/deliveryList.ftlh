<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <#list deliveries as delivery>
            <div class="card w-100" >
                <div class="card-body ">
                    <div class="row" id="myDIV">
                        <div class="col-sm-4">
                            <h3 class="font-weight-normal card-title " id="list-item-${delivery.id}">Поставка груза</h3>
                            <h4 class="font-weight-normal">Адрес забора: ${delivery.pickupAddress} </h4>
                            <h4 class="font-weight-normal">Адрес разгрузки: ${delivery.deliveryAddress}</h4>
                            <h4 class="font-weight-normal">Расстояние: ${delivery.distance}</h4>
                        </div>
                        <div class="col-sm-6">
                            <div id="collapse${delivery.id}" aria-expanded="false" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                                <h4 class="font-weight-normal"> </h4>
                                <h4 class="font-weight-normal"></h4>
                                <h4 class="font-weight-normal">Маршрут: "${delivery.pickupAddress} -
                                    <#if delivery.addressPointOne != "qwerty"> ${delivery.addressPointOne} -
                                        <#if delivery.addressPointTwo != "qwerty"> ${delivery.addressPointTwo} -
                                            <#if delivery.addressPointThree !="qwerty"> ${delivery.addressPointThree} -
                                            </#if>
                                        </#if>
                                    </#if>
                                    ${delivery.deliveryAddress}"
                                </h4>
                            </div>
                        </div>
                        <div class="col-sm-1">
                            <div class="btn-group-vertical h-100 mr-1">
                                <button class="btn btn-link text-secondary" data-toggle="collapse" data-target="#collapse${delivery.id}" aria-expanded="true" aria-controls="collapseOne">
                                    <h4>Подробнее</h4>
                                </button>
                                <a href="/deleteDelivery/${delivery.id}" class="btn btn-link text-secondary"><h4>Отменить</h4></a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        <#else>
            <h3>Загрузок нет</h3>
        </#list>

    </div>


    <script defer>

        function twoFunc () {

            document.getElementById('input1').style.display="none";

        }
        document.getElementById('input1').addEventListener('click', twoFunc, false);

    </script>
</@c.page>