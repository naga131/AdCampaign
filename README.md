# AdCampaign

# Below are the request responses
# get: http://localhost:8080/adServer/ads

Response:
[{"partnerId":101,"addContent":"John","duration":60},{"partnerId":201,"addContent":"Russ","duration":60},{"partnerId":301,"addContent":"Kate","duration":60},{"partnerId":1495649379626,"addContent":"Viral","duration":60}]


# get: http://localhost:8080/adServer/ad/1

Response:
{"partnerId":101,"addContent":"John","duration":60}

# Post: http://localhost:8080/adServer/ad

Body: {"partnerId":108,"addContent":"John123","duration":60}

Response: Successful


# With in 60 secs
Post: http://localhost:8080/adServer/ad

Body: {"partnerId":108,"addContent":"John1234","duration":60}

Response: Partner Campaign is already active






