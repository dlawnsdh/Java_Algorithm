select distinct c.car_id from CAR_RENTAL_COMPANY_CAR as c join CAR_RENTAL_COMPANY_RENTAL_HISTORY as r
    on c.car_id = r.car_id
where substring(r.start_date, 6, 2) = '10' and c.car_type = '세단'
order by c.car_id desc
