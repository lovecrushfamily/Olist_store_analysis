FROM python:3

WORKDIR /usr/src/app

COPY requirements.txt ./
COPY ecommerce_analysis.ipynb ./

RUN pip install -r requirements.txt

ENV JUPYTER_ENABLE_LAB=yes
ENV JUPYTER_TOKEN=mystarlog

EXPOSE 8888

CMD [ "jupyter","notebook","--allow-root", "."]
