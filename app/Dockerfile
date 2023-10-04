FROM cassandra:latest

ENV LANG C.UTF-8

COPY scripts/init-cassandra.cql /docker-entrypoint-initdb.d/

COPY scripts/entrypoint.sh /


ENTRYPOINT ["/entrypoint.sh"]
CMD ["cassandra", "-f", "-R"]