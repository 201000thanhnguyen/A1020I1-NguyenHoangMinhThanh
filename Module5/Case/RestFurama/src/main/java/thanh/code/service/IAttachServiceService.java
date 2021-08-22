package thanh.code.service;

import thanh.code.models.AttachService;

public interface IAttachServiceService extends ICRUDService<AttachService> {

    Iterable<AttachService> attachServiceIterable();
}
