SELECT s.sid,s.sname,s.disname,ifnull(sum(oid),0) ,format(ifnull(sum(realTotal),0),2)
 FROM shop s  left join desserthouse.`order` o on o.sid = s.sid
group by s.sid,s.sname, s.disname
order by sum(oid) desc